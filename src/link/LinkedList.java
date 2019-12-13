package link;

import javax.xml.stream.FactoryConfigurationError;

public class LinkedList {
    public static void main(String[] args) {
        Person p1 = new Person(1, "张三");
        Person p2 = new Person(2, "李四");
        Person p3 = new Person(3, "王五");
        Person p4 = new Person(4, "赵六");
        PersonLinked linked = new PersonLinked();
        linked.addOrder(p2);
        linked.addOrder(p3);
        linked.addOrder(p1);
        linked.addOrder(p4);
        linked.list();

    }
}

class Person{
    public Integer id;
    public String name;
    public Person next;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' ;
    }
}

class PersonLinked{
    //初始化头结点
    private Person head = new Person(0,"");

    public Person getHead() {
        return head;
    }
    //添加链表
    public void add(Person person){
        //定义辅助节点
        Person temp = head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp = temp.next;//节点后移
        }
        temp = person;
    }
    //按照指定顺序添加链表,假设从小到大添加
    public void addOrder(Person person){
        //定义辅助节点
        Person temp = head;
        boolean flag = false;//定义一个标志
        while (true){
            if(temp.next==null){
                break;
            }
            if(temp.next.id>person.id){//此时位置已经找到
                break;
            }else if(temp.next.id == person.id){  //添加元素已经存在
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if(flag){
            System.out.println("元素已经存在,不能添加");
        }else {
            person.next = temp.next;//新结点指向下一个节点
            temp.next = person; //原先的节点指向新结点
        }
    }
    //删除链表
    public void del(int id){
        //定义辅助节点
        Person temp = head;
        boolean flag = false;//定义一个标志
        if(temp.next==null){
            System.out.println("链表为空");
        }
        while (true){
            if(temp.next.id == id){
                flag = true;//找到要删除的节点
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;//删除节点
        }else {
            System.out.println("没有找到要删除的节点");
        }
    }
    //遍历链表
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //定义辅助变量
        Person temp = head;
        while (true){
            if(temp.next==null){
                break;//已经到链表尾部
            }
            System.out.println(temp.next);
            temp = temp.next;//节点后移
        }
    }


}
