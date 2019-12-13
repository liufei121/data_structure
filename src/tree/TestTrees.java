package tree;

public class TestTrees {
    public static void main(String[] args) {

    }
}


class Hero{
    public Integer id;
    public String name;
    public Hero left;
    public Hero right;

    public Hero(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getLeft() {
        return left;
    }

    public void setLeft(Hero left) {
        this.left = left;
    }

    public Hero getRight() {
        return right;
    }

    public void setRight(Hero right) {
        this.right = right;
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);;
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
    public Hero preSearch(int id){
        if(this.id == id){
            return this;
        }
        Hero hero = null;
        if(this.left!=null){
            hero = this.left.preSearch(id);
        }
        if(this.right!=null){
            hero = this.right.preSearch(id);
        }
        return hero;
    }
    //使用中序遍历查找
    public Hero infixSearch(int id){
        Hero hero = null;
        if(this.left!=null){
          hero = this.left.infixSearch(id);
        }
        if(hero!=null){
            return hero;
        }
        if(this.id == id){
            return this;
        }
        if(this.right!=null){
            hero = this.right.infixSearch(id);
        }
        return hero;
    }
    //使用后续遍历
    public Hero postSearch(int id){
        Hero hero = null;
        if(this.left!=null){
           hero = this.left.postSearch(id);
        }
        if(hero!=null){
            return hero;
        }
        if(this.right!=null){
            hero = this.right.postSearch(id);
        }
        if(hero!=null){
            return hero;
        }
        if(this.id==id){
            return this;
        }
        return null;
    }

    //删除
    public void delNode(int id){
        if(this.left!=null && this.left.id == id){
            this.left = null;
            return;
        }
        if(this.right!=null && this.right.id == id){
            this.right = null;
            return;
        }
        if(this.left !=null){
            this.left.delNode(id);
        }
        if(this.right!=null){
            this.right.delNode(id);
        }
    }
    //非叶子节点删除
    public void delNoLeafNode(int id){
        if(this.left!=null && this.right==null && this.id==id){
            this.id  = this.left.id;
            this.name = this.left.name;
            this.left = null;
            this.right = null;
            return;
        }
        if(this.left!=null && this.right==null){
            this.left.delNoLeafNode(id);
        }
        if(this.right!=null && this.left==null && this.id==id){
            this.id = this.right.id;
            this.name = this.right.name;
            this.left = null;
            this.right = null;
            return;
        }
        if(this.right!=null && this.left==null){
            this.right.delNoLeafNode(id);
        }
        if(this.left!=null && this.right!=null && this.id==id){
            this.id = this.left.id;
            this.name = this.left.name;
            this.left = null;
        }
        if(this.right!=null && this.left!=null){
            this.left.delNoLeafNode(id);
            this.right.delNoLeafNode(id);

        }
    }

}

class HeroTree{
    private Hero root;
    public HeroTree(Hero root){
        this.root = root;
    }
    //前序遍历
    public void preList(){
        if(this.root!=null){
           this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //中序遍历
    public void infixList(){
        if(this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //后续遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
}


