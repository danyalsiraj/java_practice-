package shapes;

import cars.ICar;

public abstract class Shape {

	private int x, y;

	public final int getX() {
		return x;
	}

	public final int getY() {
		return y;
	}

	public final void moveTo(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public abstract double area();

	public abstract void scale(double factor);

	public abstract String toString();

	// method called compareTo takes in a shape,
	// returns -1 if the current area is less than of the shape passed in
	// returns 0 if both shapes have the same area
	// return 1 if the area of the current shape is greater than of the one
	// passed in

	public int compareTo(Shape shape) {
		double currentArea = this.area();
		double shapeArea = shape.area();
		if (shapeArea > currentArea)
			return -1;
		if (shapeArea < currentArea)
			return 1;
		else
			return 0;
	}
}
