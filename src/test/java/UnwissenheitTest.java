import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

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
    /*
     * This annotation is used if you want to execute some statements before all the test cases for e.g. test connection
     * must be executed before all the test cases.
     */
    @BeforeClass
    static public void beforeClass() {
        backup = System.out;
    }
    /*
     * This annotation can be used if you want to execute some statements after all test cases for e.g. Releasing
     * resources after executing all test cases.
     */
    @AfterClass
    static public void afterClass() {
        System.setOut(backup);
    }

    @BeforeEach
    void setUp() {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);
    }

    @Test
    void testRichtigesWissen() {
        innerClass.richtigesWissen();
        verify(mockOut).println(startsWith("Gedanken an richtiges Wissen der Klasse "));
    }

    @Test
    void testIrrtum() {
        innerClass.irrtum();
        verify(mockOut).println(startsWith("Gedanken an einen Irrtum der Klasse "));
    }

    @Test
    void testVorstellung() {
        innerClass.vorstellung();
        verify(mockOut).println(startsWith("Gedanken an eine Vorstellung der Klasse "));
    }

    @Test
    void testTiefschlaf() {
        innerClass.tiefschlaf();
        verify(mockOut).println(startsWith("Gedanken an Schlaf der Klasse "));
    }

    @Test
    void testErinnerung() {
        innerClass.erinnerung();
        verify(mockOut).println(startsWith("Gedanken an eine Erinnerung der Klasse"));
    }
}