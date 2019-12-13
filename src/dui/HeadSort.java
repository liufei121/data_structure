package dui;

import java.util.Arrays;

public class HeadSort {
    public static void main(String[] args) {

        int arr[] = {4,6,8,5,9};
        headSort(arr);

    }

    public static void headSort(int arr[]){
        int temp = 0;
        System.out.println("堆排序");
//        adjustHead(arr,1,arr.length);
//        System.out.println("第一次"+ Arrays.toString(arr));
//        adjustHead(arr,0,arr.length);
//        System.out.println("第二次"+ Arrays.toString(arr));
        for(int i = arr.length / 2 - 1;i >= 0;i--){
                adjustHead(arr,i,arr.length);
        }

        for(int j=arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHead(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }
    /*
    * arr 表示调整的数组
    * i 表示非叶子节点在数组中的索引
    * length:表示对多少个元素进行调整,length是逐渐的减少
    *
    * */
    public static void adjustHead(int arr[],int i,int length){
            int temp = arr[i];
            for(int k = i*2+1;k<length;k=k*2+1){//左子结点小于右子节点
                if(k+1<length && arr[k]<arr[k+1]){
                    k++;
                }
                if(arr[k]>temp){   //子节点大于父节点
                    arr[i]=arr[k];//ba大的子节点赋值给当前节点
                    i=k;//i指向k
                }else {
                    break;
                }
            }
            //循环结束.已经将以i为父节点的树的最大值,放在了最顶部
            arr[i]=temp;
    }
}
