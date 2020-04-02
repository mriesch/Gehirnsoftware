import javassist.ClassPool;
import javassist.CtClass;
import javassist.*;
import javassist.NotFoundException;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.ClassFile;
import javassist.bytecode.DuplicateMemberException;
import javassist.bytecode.FieldInfo;

public class HelloTest {
    public static void main(String[] args) throws Exception {
        Hello orig = new Hello();
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("Hello");
        CtMethod m = cc.getDeclaredMethod("say");
        m.insertBefore("{ System.out.println(\"Hello.say(asdasdsd):\"); }");
        Class c = cc.toClass();
        Hello h = (Hello)c.newInstance();
        h.say();
    }
}
