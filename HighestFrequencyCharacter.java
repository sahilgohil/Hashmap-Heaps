    public static void highestFrequencyCharacter(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }

        Character c = 'a';
        int max = Integer.MIN_VALUE;

        for(Character ca:map.keySet())
        {
            if(map.get(ca)>max)
            {
                max = map.get(ca);
                c = ca;
            }
        }

        System.out.println("Highest Frequency Character: "+c);
        
    }
