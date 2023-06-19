public static void printLongSequenceInArray(int[] arr) {

        HashMap<Integer,Boolean> map = new HashMap<>();

        for(int i:arr)
        {
            map.put(i, true);
        }

        for(int i:map.keySet())
        {
            if(map.containsKey(i-1))
            {
                map.put(i, false);
            }
        }

        int start = 0;
        int length = 0;

        for(int i:map.keySet())
        {
            int tempStart = i;
            int tempLenght = 1;

            while(map.containsKey(tempStart+tempLenght))
            {
                tempLenght++;
                

            }
            if(tempLenght>length)
                {
                    start = tempStart;
                    length = tempLenght;   
                }
        }

        int counter = 0;
        while(counter<length)
        {
            System.out.print(start+" ");
            start++;
            counter++;
        }
        
    }
