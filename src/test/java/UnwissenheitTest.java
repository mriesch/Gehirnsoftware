import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class UnwissenheitTest  {

    static class InnerClass extends Unwissenheit {
        InnerClass(String zustand, String instensität, String ort, String zeitpunkt, String umstand, String lebewesen) {
            super(zustand, instensität, ort, zeitpunkt, umstand, lebewesen);
        }
    }

    private InnerClass innerClass =
            new InnerClass("zustand", "instensität","ort", "zeitpunkt", "umstand", "lebewesen");

    static PrintStream backup;
    PrintStream mockOut;

    @BeforeClass /* This annotation is used if you want to execute some statements before all the test cases for e.g.
    test connection must be executed before all the test cases. */
    static public void beforeClass() {
        backup = System.out;
    }

    @AfterClass  /* This annotation can be used if you want to execute some statements after all test cases for e.g.
     Releasing resources after executing all test cases. */
    static public void afterClass() {
        System.setOut(backup);
    }

    @BeforeEach
    void setUp() {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);
    }

    @Test
    void test_RichtigesWissen() {
        innerClass.richtigesWissen();
        verify(mockOut).println(startsWith("Gedanken an richtiges Wissen der Klasse "));
    }

    @Test
    void test_Irrtum() {
        innerClass.irrtum();
        verify(mockOut).println(startsWith("Gedanken an einen Irrtum der Klasse "));
    }

    @Test
    void test_Vorstellung() {
        innerClass.vorstellung();
        verify(mockOut).println(startsWith("Gedanken an eine Vorstellung der Klasse "));
    }

    @Test
    void test_Tiefschlaf() {
        innerClass.tiefschlaf();
        verify(mockOut).println(startsWith("Gedanken an Schlaf der Klasse "));
    }

    @Test
    void test_Erinnerung() {
        innerClass.erinnerung();
        verify(mockOut).println(startsWith("Gedanken an eine Erinnerung der Klasse"));
    }

    @Test
    void test_IsAbstract() {
        Class myClass = Unwissenheit.class;
        assertTrue(Modifier.isAbstract(myClass.getModifiers()));
    }

}