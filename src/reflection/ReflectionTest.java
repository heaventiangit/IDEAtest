package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 这是 java 反射机制的用法
 * @author heavenTian
 */
public class ReflectionTest {

    /**=====一:=====
     * 获取反射类型
     * 使用反射,首先要
     * 1.获取到Class类型对象
     * 2.演示获取Class类型对象的几种方式
     */
    public static void test1() throws ClassNotFoundException {

        //1.获取网虫套餐类的Class类型对象方式之一:知道类名
        //任何数据类型(包括静态属性)都有一个"静态"的class属性
        Class cls1 = NetPackage.class;
        System.out.println(cls1);

        //2.获取网虫套餐类的Class类型对象方式之二:知道对象名
        NetPackage pkg = new NetPackage();//这一new 产生一个NetPackage对象，一个Class对
        Class cls2 = pkg.getClass();//获取Class对象
        System.out.println(cls2);

        //3.获取网虫套餐类的Class类型对象方式之三:知道类的完全限定名
        Class cls3 = Class.forName("reflection.NetPackage");
        System.out.println(cls3);
    }

    /**=====二:=====
     *
     * 运行时动态创建对象
     */
    public static void test2() throws IllegalAccessException, InstantiationException {

        //获取类型对象
        Class cls1 = NetPackage.class;
        //使用类型对象的新实例方法创建对象--调用默认构造函数实例化
        Object obj = cls1.newInstance();
        //==>cls1.getConstructor().newInstance();
        //相当于==>NetPackage pkg = new NetPackage();
        /**
         * T	newInstance()
         * 创建此 Class 对象所表示的类的一个新实例。
         */
    }

    /**=====三:=====
     * 网虫套餐类
     * 运行时动态获取类的构造函数,并且调用指定的构造函数创建对象
     */
    public static void test3() throws ClassNotFoundException {

        //获取类型对象
        Class cls1 = NetPackage.class;
        //获取类定义的所有公共的构造方法
        Constructor[] cs = cls1.getConstructors();
        //遍历数组cs
        //输出构造函数的名称和参数类型
        for (Constructor c : cs) {
            String name = c.getName();
            System.out.println("=====构造函数名称:" + name + "=====");
            Class[] parameterTypes = c.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.println("\t" + (i + 1) + "." + parameterTypes[i].getName());
            }
        }
    }

    /*
     * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
     *
     * 1.获取构造方法：
     * 		1).批量的方法：
     * 			public Constructor[] getConstructors()：所有"公有的"构造方法
                public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)

     * 		2).获取单个的方法，并调用：
     * 			public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
     * 			public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
     *
     * 			调用构造方法：
     * 			Constructor-->newInstance(Object... initargs)
     */
    public static void test4() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {

        //1.加载Class对象
        Class clazz = Class.forName("reflection.Student");


        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = clazz.getConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }


        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = clazz.getDeclaredConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con = clazz.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。

        System.out.println("con = " + con);
        //调用构造方法
        Object obj = con.newInstance();
//        	System.out.println("obj = " + obj);
//        	Student stu = (Student)obj;

        System.out.println("******************获取私有构造方法，并调用*******************************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = con.newInstance('男');
    }

    /**====四:=====
     * 网虫套餐类
     * 运行时动态获取类的公共方法
     */
    public static void test5() {

        //获取类型对象
        Class cls1 = NetPackage.class;
        //获取类定义的所有公共方法
        Method[] methods = cls1.getDeclaredMethods();
        //遍历方法数组
        for (Method m:methods) {
            System.out.println("------------------");
            System.out.println("方法名"+m.getName());
            System.out.println("返回类型"+m.getReturnType());
            Class<?>[] pTypes = m.getParameterTypes();
            System.out.println("参数类型");
            for(Class<?> p:pTypes){
                System.out.println("\t"+p.getName());
            }
            System.out.println("----------------------------");
        }
    }

    /*
     * 获取成员变量并调用：
     *
     * 1.批量的
     * 		1).Field[] getFields():获取所有的"公有字段"
     * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
     * 2.获取单个的：
     * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
     * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
     *
     * 	 设置字段的值：
     * 		Field --> public void set(Object obj,Object value):
     * 					参数说明：
     * 					1.obj:要设置的字段所在的对象；
     * 					2.value:要为字段设置的值；
     *
     */
    public static void getField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        //1.获取Class对象
        Class stuClass = Class.forName("reflection.Student");
        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = stuClass.getFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fieldArray = stuClass.getDeclaredFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }
        System.out.println("*************获取公有字段**并调用***********************************");
        Field f = stuClass.getField("name");
        System.out.println(f);
        //获取一个对象
        Object obj = stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
        //为字段设置值
        f.set(obj, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"
        //验证
        Student stu = (Student)obj;
        System.out.println("验证姓名：" + stu.name);


        System.out.println("**************获取私有字段****并调用********************************");
        f = stuClass.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj, "18888889999");
        System.out.println("验证电话：" + stu);
    }

    /*
     * 获取成员方法并调用：
     *
     * 1.批量的：
     * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
     * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
     * 2.获取单个的：
     * 		public Method getMethod(String name,Class<?>... parameterTypes):
     * 					参数：
     * 						name : 方法名；
     * 						Class ... : 形参的Class类型对象
     * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
     *
     * 	 调用方法：
     * 		Method --> public Object invoke(Object obj,Object... args):
     * 					参数说明：
     * 					obj : 要调用方法的对象；
     * 					args:调用方式时所传递的实参；
     *                   ):
     */
    public static void getMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //1.获取Class对象
        Class stuClass = Class.forName("reflection.Student");
        //2.获取所有公有方法
        System.out.println("***************获取所有的”公有“方法*******************");
        Method[] methodArray = stuClass.getMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        methodArray = stuClass.getDeclaredMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        //实例化一个Student对象
        Object obj = stuClass.getConstructor().newInstance();
        m.invoke(obj, "刘德华");

        System.out.println("***************获取私有的show4()方法******************");
        m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {

//        test1();
//        test2();
//        test3();
//        test4();
//        getField();
//        test5();
        getMethod();
    }
}
