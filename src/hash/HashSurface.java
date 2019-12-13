package hash;

public class HashSurface {
    public static void main(String[] args) {
        HashLinkedList hash = new HashLinkedList(10);
        HeroNode node1 = new HeroNode(5, "宋江");
        HeroNode node2 = new HeroNode(18, "武松");
        HeroNode node3 = new HeroNode(3, "鲁智深");
        HeroNode node4 = new HeroNode(20, "花荣");
        HeroNode node5 = new HeroNode(34, "林冲");
        HeroNode node6= new HeroNode(15, "公孙胜");
        hash.add(node1);
        hash.add(node2);
        hash.add(node3);
        hash.add(node4);
        hash.add(node5);
        hash.add(node6);
        hash.list();
    }
}


class HashLinkedList{
    public HeroNodeLinked[] heroNodeLinked;
    public Integer size;

    public HashLinkedList(Integer size) {
        this.size = size;
        heroNodeLinked= new HeroNodeLinked[size];
        for(int i=0;i<size;i++){
            heroNodeLinked[i] = new HeroNodeLinked();
        }
    }
    //定义散列函数
    public Integer randomId(int id){
        return id/size;
    }
    //添加英雄
    public void add(HeroNode heroNode){
        int i = randomId(heroNode.id);
        heroNodeLinked[i].add(heroNode);
    }
    //遍历哈希表
    public void list(){
        if(heroNodeLinked.length==0){
            System.out.println("哈希表为空");
        }
        for(int i=0;i<size;i++){
            heroNodeLinked[i].list();
        }
    }
}

class HeroNode{
    public Integer id;
    public String name;
    public HeroNode next;

    public HeroNode(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}


class HeroNodeLinked{
    private HeroNode head; //默认为null;

    public void add(HeroNode heroNode){
        if(head==null){
            head = heroNode;
            return;
        }
        HeroNode temp = head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void list(){
        if(head==null){
            System.out.println("表为空");
            return;
        }
        HeroNode temp = head;
        System.out.println("链表结构");
        while (true){
            System.out.println(temp);
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }

    }
}
