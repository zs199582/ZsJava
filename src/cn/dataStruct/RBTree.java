package cn.dataStruct;

/**
 * 红黑树
 */
public class RBTree<T extends Comparable<T>> {
    private static final Boolean BLACK = false;
    public static final Boolean RED = true;
    private RBTNode<T> mRoot;
    public class RBTNode<T extends  Comparable<T>>{
        boolean color;
        T key;
        RBTNode<T> left;
        RBTNode<T> right;
        RBTNode<T> parent;
        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right)
        {
            this.key = key;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
    public void setBlack(RBTNode node)
    {
        node.color = BLACK;
    }
    public void setRed(RBTNode node)
    {
        node.color = RED;
    }
    private boolean isRed(RBTNode node)
    {
        if(node.color == RED) return true;
        return false;
    }
    private boolean isBlack(RBTNode node)
    {
        if(node.color == BLACK) return true;
        return false;
    }
    private RBTNode<T> parentOf(RBTNode<T> node){return node.parent;}
    private void setParent(RBTNode<T>node ,RBTNode<T>parent){
        if(node!=null)
            node.parent = parent;
    }
    private boolean colorOf(RBTNode<T> node)
    {
        if(node!=null)
        return node.color;
        return false;
    }
    private void setColor(RBTNode<T> node,boolean color)
    {
        if(node!=null)
            node.color = color;
    }
    /**
     * 左旋
     * @param x
     */
    public void leftRotate(RBTNode<T> x)
    {
        RBTNode<T> y = x.right;
        //把y的左孩子设为x的右孩子
        x.right = y.left;
        if(y.left!=null)
            y.left.parent = x;
        //如果x的父节点为空 将y设为mRoot
        if(x.parent==null)
        {
            this.mRoot = y;
        }
        else
        {
            if(x.parent.left == x)
                x.parent.left = y;
            else if(x.parent.right == x)
                    x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
        //如果x的父节点不为空 x的parent设为
    }

    /**
     * 将x右旋
     * @param x
     */
    public void rightRotate(RBTNode<T> x)
    {
        //x的左孩子
        RBTNode<T> y = x.left;
        x.left = y.right;
        if(y.right!=null)
            y.right.parent = x;
        //忘了将y的父节点设置
        y.parent = x.parent;
        //
        if(x.parent == null)
            this.mRoot = y;
        else
        {
            if(x.parent.left == x)
                x.parent.left = y;
            else if(x.parent.right  == x)
                x.parent.right = y;
        }
        y.right = x;
        x.parent = y;
    }

    /**
     * 插入
     * @param x
     */
    public void insert(RBTNode<T> x)
    {
        //1.类似二叉排序树的插入
        //比较的值
        int cmp;
        RBTNode<T> node = this.mRoot;
        RBTNode<T> y = node;
        while(node!=null)
        {
            y = node;
            cmp = x.key.compareTo(node.key);
            //如果插入节点比node小
            if(cmp<0) node = node.left;
            //如果插入结点比node大
            else node = node.right;
        }
        x.parent = y;
        if(y!=null)
        {
            cmp = x.key.compareTo(y.key);
            if(cmp<0)
                y.left = x;
            else if(cmp>=0)
                y.right = x;
        }
        else this.mRoot = x;
        //2.设置结点的颜色为红色
        node.color = RED;
        //3.将树重新修正为一棵二叉查找树
        insertFixUp(x);
    }
    public void insert(T key) {
        RBTNode<T> node = new RBTNode<>(key, BLACK, null, null, null);
        if (node != null)
            insert(node);
    }

    /**
     * 插入修正
     * @param node
     */
    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent, gparent;

        // 若“父节点存在，并且父节点的颜色是红色”
        while (((parent = parentOf(node))!=null) && isRed(parent)) {
            gparent = parentOf(parent);

            //若“父节点”是“祖父节点的左孩子”
            if (parent == gparent.left) {
                // Case 1条件：叔叔节点是红色
                RBTNode<T> uncle = gparent.right;
                if ((uncle!=null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                if (parent.right == node) {
                    RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {    //若“z的父节点”是“z的祖父节点的右孩子”
                // Case 1条件：叔叔节点是红色
                RBTNode<T> uncle = gparent.left;
                if ((uncle!=null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是左孩子
                if (parent.left == node) {
                    RBTNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是右孩子。
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        // 将根节点设为黑色
        setBlack(this.mRoot);
    }
    /*
     * 删除结点(node)，并返回被删除的结点
     *
     * 参数说明：
     *     node 删除的结点
     */
    private void remove(RBTNode<T> node) {
        RBTNode<T> child, parent;
        boolean color;

        // 被删除节点的"左右孩子都不为空"的情况。
        if ( (node.left!=null) && (node.right!=null) ) {
            // 被删节点的后继节点。(称为"取代节点")
            // 用它来取代"被删节点"的位置，然后再将"被删节点"去掉。
            RBTNode<T> replace = node;

            // 获取后继节点
            replace = replace.right;
            while (replace.left != null)
                replace = replace.left;

            // "node节点"不是根节点(只有根节点不存在父节点)
            if (parentOf(node)!=null) {
                if (parentOf(node).left == node)
                    parentOf(node).left = replace;
                else
                    parentOf(node).right = replace;
            } else {
                // "node节点"是根节点，更新根节点。
                this.mRoot = replace;
            }

            // child是"取代节点"的右孩子，也是需要"调整的节点"。
            // "取代节点"肯定不存在左孩子！因为它是一个后继节点。
            child = replace.right;
            parent = parentOf(replace);
            // 保存"取代节点"的颜色
            color = colorOf(replace);

            // "被删除节点"是"它的后继节点的父节点"
            if (parent == node) {
                parent = replace;
            } else {
                // child不为空
                if (child!=null)
                    setParent(child, parent);
                parent.left = child;

                replace.right = node.right;
                setParent(node.right, replace);
            }

            replace.parent = node.parent;
            replace.color = node.color;
            replace.left = node.left;
            node.left.parent = replace;

            if (color == BLACK)
                removeFixUp(child, parent);

            node = null;
            return ;
        }

        if (node.left !=null) {
            child = node.left;
        } else {
            child = node.right;
        }

        parent = node.parent;
        // 保存"取代节点"的颜色
        color = node.color;

        if (child!=null)
            child.parent = parent;

        // "node节点"不是根节点
        if (parent!=null) {
            if (parent.left == node)
                parent.left = child;
            else
                parent.right = child;
        } else {
            this.mRoot = child;
        }

        if (color == BLACK)
            removeFixUp(child, parent);
        node = null;
    }
    /*
     * 红黑树删除修正函数
     *
     * 在从红黑树中删除插入节点之后(红黑树失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     *
     * 参数说明：
     *     node 待修正的节点
     */
    private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
        RBTNode<T> other;

        while ((node==null || isBlack(node)) && (node != this.mRoot)) {
            if (parent.left == node) {
                other = parent.right;
                if (isRed(other)) {
                    // Case 1: x的兄弟w是红色的
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }

                if ((other.left==null || isBlack(other.left)) &&
                        (other.right==null || isBlack(other.right))) {
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.right==null || isBlack(other.right)) {
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = this.mRoot;
                    break;
                }
            } else {

                other = parent.left;
                if (isRed(other)) {
                    // Case 1: x的兄弟w是红色的
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }

                if ((other.left==null || isBlack(other.left)) &&
                        (other.right==null || isBlack(other.right))) {
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.left==null || isBlack(other.left)) {
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }

                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    node = this.mRoot;
                    break;
                }
            }
        }

        if (node!=null)
            setBlack(node);
    }
}
