class Laptop {
    String cpu;
    int ram;
    int storage;
    String gpu;

    public Laptop(
            String cpu,
            int ram,
            int storage,
            String gpu
    ) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", gpu='" + gpu + '\'' +
                '}';
    }

    public Laptop(Builder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.storage = builder.storage;
        this.ram = builder.ram;
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private String gpu;

        @Override
        public String toString() {
            return "Builder{" +
                    "cpu='" + cpu + '\'' +
                    ", ram=" + ram +
                    ", storage=" + storage +
                    ", gpu='" + gpu + '\'' +
                    '}';
        }

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder storage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Laptop build() {
            return new Laptop(this);
        }
    }
}
