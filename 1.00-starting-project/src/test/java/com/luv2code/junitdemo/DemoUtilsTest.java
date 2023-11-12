package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    /**
     * @Method O método executa antes da execução de cada teste
     */
    @BeforeEach
    void setupBeforeEach(){
        demoUtils = new DemoUtils();
    }

    @Test
    @Order(1)
    @DisplayName("Testa equals and not equals")
    void testEqualsAndNotEquals(){
        System.out.println("Running test: testEqualsAndNotEquals");
        assertEquals(6, demoUtils.add(2,4), "Testa se o valor especificado e igual ao retorno da funcao");
        assertNotEquals(6, demoUtils.add(1,9), "Testa se o valor informado não e igual ao retorno da funcao");
    }

    @Test
    @Order(2)
    @DisplayName("Testa nullo e nao nullo")
    void testNullAndNotNull(){
        String str1 = null;
        String str2 = "Diogo";
        assertNull(demoUtils.checkNull(str1), "O valor retornado na funcao deve ser nulo");
        assertNotNull(demoUtils.checkNull(str2), "O valor retornado na funcao nao deve ser nulo");
    }

    @DisplayName("Testa igual e diferente")
    @Test
    void testSameAndNotSame(){
        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Os objetos devem se referir ao mesmo objeto");
        assertNotSame(str, demoUtils.getAcademy(), "Os objetos nao devem ser referir ao mesmo objeto");
    }

    @DisplayName("Teste multiplicacao")
    @Test
    void testMultiply(){
        assertEquals(15, demoUtils.multiply(3,5), "3*5 deve ser 15");
        assertNotEquals(12, demoUtils.multiply(3,5), "3*4 nao deve ser 12");
    }
    @DisplayName("Testa verdadeiro e falso")
    @Test
    @Order(4)
    void testTrueAndFalse(){
        int gradeOne = 10;
        int gradeTwo  = 5;
        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "a nota 1 é menor que a nota 2");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "A nota 2 nao e menor q a nota 1");
    }

    @DisplayName("Testa se os arrays sao profundamente iguais")
    @Test
    @Order(3)
    void testArrayEquals(){
        String[] stringArray = {"A", "B", "C"};
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays devem ser profundamente iguais");

    }
    @DisplayName("Testa se os Itarables sao profundamente iguais")
    @Test
    void testIterableEquals(){
        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Iteraveis (iterable) devem ser os mesmos");
    }
    @DisplayName("Listas de Strings List<String> devem ser iguais")
    @Test
    void testLinesMatch(){
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Listas de Strings devem ser iguais List<String>");
    }

    @DisplayName("Testa se uma excecao especificada e lancada")
    @Test
    void testThrowsandDoesNotThrow(){
        assertThrows(Exception.class, ()->{ demoUtils.throwException(-1);},"Deve lancar uma excecao pq -1 nao e > 0" );
        assertDoesNotThrow(()->{demoUtils.throwException(9);}, "Não deve lancar uma excecao pq 9 > 0");
    }
    @DisplayName("Testa se um metodo executa num determinado timout")
    @Test
    void testTimeout(){
        assertTimeoutPreemptively(Duration.ofSeconds(3), ()->{ demoUtils.checkTimeout();}, "O método deve executar em 3 segundos ou menos");
    }
    /*
    @AfterEach
    void tearDownAfterEach(){
        System.out.println("Running @AfterEach Executa depois que cada método termina sua execução");
        System.out.println("");
    }

    @BeforeAll
    static void setupBeforeAllTestMethodsRun(){
        System.out.println("@BeforeAll Executa apenas uma vez antes de rodas os métodos");
        System.out.println("");
    }

    @AfterAll
    static void tearDownAfterAllMethodsRuns(){
        System.out.println("@AfterAll Axecuta apenas uma vez após a execução de todos os testes");
    }
     */

}
