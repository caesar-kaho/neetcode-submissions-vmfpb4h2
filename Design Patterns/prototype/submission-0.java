interface Shape {
    Shape clone();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public Shape clone() {
        // Write your code here
        Shape newShape = new Rectangle(this.width, this.height);
        return newShape;
    }
}

class Square implements Shape {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public Shape clone() {
        // Write your code here
        Shape newShape = new Square(this.length);
        return newShape;
    }
}

class Test {
    public List<Shape> cloneShapes(List<Shape> shapes) {
        List<Shape> lists = new ArrayList<>();
        // Write your code here
        for(Shape shape : shapes) {
            Shape clonedShape = shape.clone();
            lists.add(clonedShape);
        }

        return lists;
    }
}
