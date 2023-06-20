 public static class HashMaps<K, V>{
        public class HashNode{
            K key;
            V val;

            public HashNode(K key, V val)
            {
                this.key =key;
                this.val = val;
            }
        }
        int size;
        LinkedList<HashNode>[] bucketList;

        public HashMaps()
        {
            initialize(4);
            this.size = 0;
        }

        private void initialize(int n)
        {
            this.bucketList = new LinkedList[n];
            for(int i=0;i<bucketList.length;i++)
            {
                bucketList[i] = new LinkedList<>();
            }
        }

        public void put(K key, V val)
        {
            int bucketIdx = hashFunc(key);
            int dataIdx = getIdxWithinBucket(key, bucketIdx);

            if(dataIdx == -1)
            {
                HashNode newNode = new HashNode(key, val);
                bucketList[bucketIdx].add(newNode);
                size++;
            }
            else{
                HashNode newNode = new HashNode(key, val);
                bucketList[bucketIdx].set(dataIdx, newNode);
            }

            double lambda = size * 1.0 / bucketList.length;
            if(lambda > 2.0)
            {
                rehash();
            }
        }

        public void rehash()
        {
            LinkedList<HashNode>[] oldBucketList = bucketList;

            initialize(oldBucketList.length * 2);
            size = 0;

            for(int i=0;i<oldBucketList.length;i++)
            {
                for(HashNode node:oldBucketList[i])
                {
                    put(node.key, node.val);
                }
            }

        }

        public boolean containesKey(K key)
        {
            int bucketIdx = hashFunc(key);
            int dataIdx = getIdxWithinBucket(key, bucketIdx);

            if(dataIdx == -1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public V get(K key)
        {
            int bucketIdx = hashFunc(key);
            int dataIdx = getIdxWithinBucket(key, bucketIdx);

            if(dataIdx == -1)
            {
                return null;
            }
            else{
                
               return bucketList[bucketIdx].get(dataIdx).val;
            }

        }

        public V remove(K key)
        {
            int bucketIdx = hashFunc(key);
            int dataIdx = getIdxWithinBucket(key, bucketIdx);

            if(dataIdx == -1)
            {
                return null;
            }
            else{
                size--;
               return bucketList[bucketIdx].remove(dataIdx).val;
            }
        }

        public int size(){
            return this.size;
        }

        public ArrayList<K> keySet() throws Exception{
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0;i<bucketList.length;i++)
            {
                for(HashNode node:bucketList[i])
                {
                    keys.add(node.key);
                }
            }
            return keys;
        }



        private int hashFunc(K key)
        {
            int hcode = key.hashCode();
            return Math.abs(hcode)%bucketList.length;
        }

        private int getIdxWithinBucket(K key, int bucketIdx)
        {
            int idx = 0;
            for(HashNode node: bucketList[bucketIdx])
            {
                if(node.key.equals(key))
                {
                    return idx;
                }
                idx++;
            }
            return -1;
        }
    }
