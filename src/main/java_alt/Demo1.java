import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.ClassFile;
import javassist.bytecode.DuplicateMemberException;
import javassist.bytecode.FieldInfo;

import java.lang.reflect.Field;

public class Demo1 {

    public static void main(String[] args) throws CannotCompileException {

        System.out.println("Start");
        ClassFile cf = new ClassFile(
                false, "com.baeldung.JavassistGeneratedClass", null);
        cf.setInterfaces(new String[] {"java.lang.Cloneable"});

        FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
        f.setAccessFlags(AccessFlag.PUBLIC);
        cf.addField(f);

        System.out.println("Test");
        ClassPool classPool = ClassPool.getDefault();
        Field[] fields = classPool.makeClass(cf).toClass().getFields();

        System.out.println(        fields[0].getName() );


    }
}
