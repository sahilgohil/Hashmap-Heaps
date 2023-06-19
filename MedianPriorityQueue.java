static class MedianPriorityQueue{
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue()
        {
            this.left = new PriorityQueue<>(Collections.reverseOrder());
            this.right = new PriorityQueue<>();
        }

        public void add(int val)
        {
            if(right.size() >0 && val>right.peek())
            {
                right.add(val);
            }
            else{
                left.add(val);
            }

            if(right.size() - left.size() == 2)
            {
                left.add(right.remove());
            }
            else if(left.size() - right.size() == 2)
            {
                right.add(left.remove());
            }

        }
        public int peek()
        {
            if(left.size() ==0 && right.size() == 0)
            {
                System.out.println("Underflow");
                return -1;
            }
            if(left.size()>= right.size())
            {
               return left.peek();
            }
            else{
                return right.peek();
            }


        }
        public int remove()
        {
            if(left.size() ==0 && right.size() == 0)
            {
                System.out.println("Underflow");
                return -1;
            }
            if(left.size()>= right.size())
            {
               return left.remove();
            }
            else{
                return right.remove();
            }
        }
        public int size()
        {
            return left.size()+right.size();
        }


    }
