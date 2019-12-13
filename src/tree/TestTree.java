package tree;

public class TestTree {
    public static void main(String[] args) {
        BinayTree binayTree = new BinayTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binayTree.setRoot(root);
        //测试前序遍历
//        System.out.println("前序遍历");//1 ,2 3 ,5 ,4
//        binayTree.preOrder();
//        System.out.println("中序遍历");//2,1,5,3,4
//        binayTree.infixOrder();
//        System.out.println("后续遍历");//2,5,4,3,1
//        binayTree.postOrder();

        //前序遍历
//        System.out.println("前序遍历查找方式");
//        HeroNode resNode = binayTree.preOrderSearch(5);
//        if(resNode!=null){
//            System.out.printf("no=%d name=%s",resNode.getNo(),resNode.getName());
//        }else {
//            System.out.printf("没有找到no = %d 的英雄",5);
//        }

//        System.out.println("中序遍历查找方式");
//        HeroNode resNode1 = binayTree.infixOrderSearch(5);
//        if(resNode1!=null){
//            System.out.printf("no=%d name=%s",resNode1.getNo(),resNode1.getName());
//        }else {
//            System.out.printf("没有找到no = %d 的英雄",5);
//        }
//        System.out.println("后序遍历查找方式");
//        HeroNode resNode2 = binayTree.postOrderSearch(2);
//        if(resNode2!=null){
//            System.out.printf("no=%d name=%s",resNode2.getNo(),resNode2.getName());
//        }else {
//            System.out.printf("没有找到no = %d 的英雄",2);
//        }
        //测试删除方法
//        System.out.println("删除前:前序遍历");
//        binayTree.preOrder();
//        binayTree.delNode(5);
//       // binayTree.delNode(3);
//        System.out.println("删除后,前序遍历");
//        binayTree.preOrder();
        binayTree.delNoLeafNode(3);
        binayTree.preOrder();

    }
}

class BinayTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //删除节点
    public void delNode(int no){
        if(root!=null){
            //判断root是不是删除的节点
            if(root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }
    }
    //删除非子页节点
    public void delNoLeafNode(int no){
        if(root!=null){
            //判断root是不是删除的节点
            if(root.getNo()==no){
                root=null;
            }else {
                root.delNoLeafNode(no);
            }
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        if(root!=null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        if(root!=null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后续遍历查找
    public HeroNode postOrderSearch(int no){
        if(root!=null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }

}
class HeroNode{

    public int no;
    public String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
    //删除
    public void delNode(int no){
        if(this.left!=null && this.left.no == no){
            this.left = null;
            return;
        }
        if(this.right!=null && this.right.no == no){
            this.right = null;
            return;
        }
        if(this.left !=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
    //非叶子节点删除
    public void delNoLeafNode(int no){
        if(this.left!=null && this.right==null && this.no==no){
            this.no = this.left.no;
            this.name = this.left.name;
            this.left = null;
            this.right = null;
            return;
        }
        if(this.left!=null && this.right==null){
            this.left.delNoLeafNode(no);
        }
        if(this.right!=null && this.left==null && this.no==no){
            this.no = this.right.no;
            this.name = this.right.name;
            this.left = null;
            this.right = null;
            return;
        }
        if(this.right!=null && this.left==null){
            this.right.delNoLeafNode(no);
        }
        if(this.left!=null && this.right!=null && this.no==no){
            this.no = this.left.no;
            this.name = this.left.name;
            this.left = null;
        }
        if(this.right!=null && this.left!=null){
            this.left.delNoLeafNode(no);
            this.right.delNoLeafNode(no);

        }
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){

        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    //后续遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //使用前序遍历查找
    public HeroNode preOrderSearch(int no){
        System.out.println("前入前续遍历");
        if(this.no == no){
            System.out.println(this);
        }
        HeroNode resNode = null;
        if(this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }
    //使用中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        if(this.left!=null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入中序查找");
        if(this.no == no){
            return this;
        }
        if(this.right!=null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    //后续遍历
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if(this.left!=null){
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入后续遍历");
        if(this.no == no){
            return this;
        }
        return resNode;
    }

}
