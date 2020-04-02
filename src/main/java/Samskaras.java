import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import javassist.*;
import javassist.util.HotSwapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Samskaras {

    public static void loeschenUnwissenheit() throws IOException, IllegalConnectorArgumentsException, NotFoundException, CannotCompileException {

        HotSwapper hs = new HotSwapper(7896);

        // Run Hello Word.
        HelloWorld h = new HelloWorld();
        h.print();

        // Create new Hello Word base on Hello Word.
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("Unwissenheit");
        CtMethod m = cc.getDeclaredMethod("erinnerung");
        m.setBody("{}");
        m = cc.getDeclaredMethod("irrtum");
        m.setBody("{}");
        //m.insertBefore("{ System.out.println($1); System.out.println($2); }");
        cc.writeFile("gehirnsoftware");

        // Load new file.
        File newfile = new File("gehirnsoftware\\Unwissenheit.class");

        byte[] bytes = new byte[(int)newfile.length()];

        FileInputStream fileInputStream = new FileInputStream(newfile);
        int i = fileInputStream.read(bytes);
        System.out.println("** reload new Unwissenheit class with " +  i + " bytes");

        hs.reload("Unwissenheit", bytes);




    }

    public static void main(String[] args) throws IOException, IllegalConnectorArgumentsException, NotFoundException, CannotCompileException{
        //Entstehung
        Verlangen eiscreamEssen;

        eiscreamEssen = new Verlangen("Aktiv",
                "0,85",
                "zuhause bei Mutter",
                "4 Jahre und 3 Monate",
                "Erste Eiscreme hat sehr gut geschmeckt",
                "Mensch");

         // Aktivieren zweier Denkmuster.
         eiscreamEssen.irrtum();
         eiscreamEssen.erinnerung();


        System.out.println("eiscreamEssen.instensität: " + eiscreamEssen.instensität);
        System.out.println("eiscreamEssen.ort: " + eiscreamEssen.ort);
        System.out.println("eiscreamEssen.zeitpunkt: " + eiscreamEssen.zeitpunkt);
        System.out.println("eiscreamEssen.umstand: " + eiscreamEssen.umstand);
        System.out.println("eiscreamEssen.lebewesen: " + eiscreamEssen.lebewesen);

        // Lösche Unwissenheit

        loeschenUnwissenheit();

        // Aktivieren zweier Denkmuster.
        System.out.println("// Nochmal aktivieren zweier Denkmuster.");
        eiscreamEssen.irrtum();
        eiscreamEssen.erinnerung();

        System.out.println("//Ende Programm");

    }


}
