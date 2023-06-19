    public static void printExactlyCommonElements(int[] arr1, int[] arr2) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr1.length;i++)
        {   
            int curr = arr1[i];
            map.put(curr, 0);
        }

        for(int i=0;i<arr2.length;i++)
        {
            int curr = arr2[i];
            if(map.containsKey(curr))
            {
                map.put(curr, map.get(curr)+1);
            }
        }
        for(Integer i:map.keySet())
        {
            if(map.get(i) >0)
            {
                for(int j=0;j<map.get(i);j++)
                {
                    System.out.print(i+" ");
                }
            }
        }
        
    }
