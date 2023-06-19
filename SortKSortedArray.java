public static void sortKSortedArray(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<=k;i++)
        {
            pq.add(arr[i]);
        }

        for(int i=k+1;i<arr.length;i++)
        {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }

        while(pq.size()>0)
        {
            System.out.println(pq.remove());
        }
        
    }
