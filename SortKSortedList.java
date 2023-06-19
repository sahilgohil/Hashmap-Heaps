  public static void sortKlistSorted(ArrayList<List<Integer>> lists) {

        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0;i<lists.size();i++)
        {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }

        while(pq.size()>0)
        {
            Pair p = pq.remove();
            ans.add(p.val);
            p.vi++;
            if(p.vi < lists.get(p.li).size())
            {
                p.val = lists.get(p.li).get(p.vi);
                pq.add(p);
            }
        }

        System.out.println(ans);
    }
