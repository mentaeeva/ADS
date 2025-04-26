package ASSIGNMENT3;

   public class MyTestingClass {

        private int id;
        private String name;

        public MyTestingClass(int id, String name) {
            this.id = id;
            this.name = name;
        }

        //my hashcode method
        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + id;
            for (char c : name.toCharArray()) {
                hash = 31 * hash + c;
            }
            return hash;
        }
        //to know if 2 obj are equal/exists/comparing id and name
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            MyTestingClass other = (MyTestingClass) obj;
            return id == other.id && name.equals(other.name);
        }
    }



