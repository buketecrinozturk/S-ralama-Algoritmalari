/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author buketecrin
 */
public class SiralamaFonksiyonlari {
    //int dizi[]={25,69,58,2,32,1,7,17,0};
    //-----------------------bouble sort----------------------------------------
public int[] boubleSort(int dizi[],int n){
        System.out.println("*****boublesort*******");
        // her geçişte sadece bir sırlama yapacak
        int yedek;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n-1; j++)
            {
                if(dizi[j]>dizi[j+1]){
                    yedek=dizi[j];
                    dizi[j]=dizi[j+1];
                    dizi[j+1]=yedek;
                }
            }
        }
        
        return dizi;
    
    
    }
    //-----------------------insertion sort-------------------------------------
public int[] insertionSort(int dizi[],int n){
int yedek=0; int j,i;
for(i=1; i<n; i++){
    yedek=dizi[i];
    j=i;
    while((j>0) && (dizi[j-1]>yedek)){
        dizi[j]=dizi[j-1];
        j--;
    }
    dizi[j]=yedek;
}
return dizi;
}
  
public int[] selectionSort(int dizi[],int n){

    int i,j,minIndex,yedek=0;
    for(i=0; i<n; i++){
        minIndex=i;
        for(j=i+1; j<n; j++){
            if(dizi[minIndex]>dizi[j]){
                minIndex=j;
            }
        }
            yedek=dizi[i];
            dizi[i]=dizi[minIndex]; 
            dizi[minIndex]=yedek;
    }
    
    return dizi;
}
//************************** merge sort ****************************************
void merge(int dizi[], int left, int m, int right)
    {
        // iki alt array'in boyutu hesaplanıyor
        int n1 = m - left + 1;
        int n2 = right - m;
 
        /* alt array boyutunda iki boş array oluşturuyoruz */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*boş arraylere dataları kopyalıyoruz*/
        for (int i=0; i<n1; ++i)
            L[i] = dizi[left + i];
        for (int j=0; j<n2; ++j)
            R[j] = dizi[m + 1+ j];
 
 
        /* Geçici oluşturulan dizileri birleştiriyoruz */
 
        // ilk ve ikinci alt dizinin başlangıç indisileri 0 olsun
        int i = 0, j = 0;
 
        // başlangıçta alt dizileri birleştirme indisi
        int k = left;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j]) // sol sağdan küçükse
            {
                dizi[k] = L[i];
                i++;
            }
            else
            {
                dizi[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            dizi[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            dizi[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
public int[] merge_sort(int dizi[], int left, int right)
    {
        if (left < right)
        {
            // Find the middle point
            int m = (left+right)/2;
             // Sort first and second halves
            merge_sort(dizi, left, m);
            merge_sort(dizi , m+1, right);
             // Merge the sorted halves
            merge(dizi, left, m, right);
        }
        return dizi;
    }
//************************ quick sort ******************************************
int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // Eğer pivot elemandan daha küçük yada eşitse
            if (arr[j] <= pivot)
            {
                i++;
                 // swap işlemi yap arr[i] ve arr[j] arasında
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
         // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
         return i+1;
    }
    public int[] sort_quick(int dizi[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(dizi, low, high);
             // Recursively sort elements before
            // partition and after partition
            sort_quick(dizi, low, pi-1);
            sort_quick(dizi, pi+1, high);
        }
        return  dizi;
    }
}
