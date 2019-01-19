package org.xstefank;

public class Avenger {
    
    private String name;
    private String realName;
    private boolean alive;

    public Avenger() {
    }

    public Avenger(String name, String realName, boolean alive) {
        this.name = name;
        this.realName = realName;
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public static AvengerBuilder name(String name) {
        return new AvengerBuilder(name);
    }
    
    public static class AvengerBuilder {
        private String name;
        private String realName;
        private boolean alive;

        public AvengerBuilder(String name) {
            this.name = name;
        }

        public AvengerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AvengerBuilder realName(String realName) {
            this.realName = realName;
            return this;
        }

        public AvengerBuilder alive(boolean alive) {
            this.alive = alive;
            return this;
        }
        
        public Avenger build() {
            return new Avenger(name, realName, alive);
        }
    }
}
