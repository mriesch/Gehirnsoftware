import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.ClassFile;
import javassist.bytecode.DuplicateMemberException;
import javassist.bytecode.FieldInfo;

public class Demo3 {

    public static void main(String[] args) throws NotFoundException, DuplicateMemberException {
        System.out.println("Start");
        ClassFile cf = ClassPool.getDefault()
                .get("Point").getClassFile();

        FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
        f.setAccessFlags(AccessFlag.PUBLIC);
        cf.addField(f);
    }
}
