  public PriorityQueues(int[] arr)
        {
            this.pq = new ArrayList<>();
            for(int i:arr)
            {
                pq.add(i);
            }

            for(int i= (pq.size()/2) -1;i>=0;i--)
            {
                downhipify(i);
            }
        }
