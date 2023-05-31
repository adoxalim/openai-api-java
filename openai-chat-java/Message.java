    class Message {
        private String role;
        private String content;
        private String name;

        public Message(String role, String content, String name){
            this.role = role;
            this.content = content;
            this.name = name;
        }

        public String getRole(){
            return this.role;
        }

        public String getContent(){
            return this.content;
        }

        public String getName(){
            return this.name;
        }

        public void setRole(String role){
            this.role = role;
        }

        public void setContent(String content){
            this.content = content;
        }

        public void setName(String name){
            this.name = name;
        }
    }