
public class Card {
	
	private int color;
	private int shape;
	private int shading;
	private int number;
	private int[] attributes;
	
	public Card() {	}
	
	public Card(int color, int shape, int shading, int number) {
		this.color = color;
		this.shape = shape;
		this.shading = shading;
		this.number = number;
		this.attributes = new int[]{color,shape,shading,number}; 
				
	}
	

	public int getNumber() {
		return number;
	}


	public int getShading() {
		return shading;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setShape(int shape) {
		this.shape = shape;
	}

	public void setShading(int shading) {
		this.shading = shading;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setAttributes(int[] attributes) {
		this.attributes = attributes;
	}

	public int getShape() {
		return shape;
	}


	public int getColor() {
		return color;
	}

	public int[] getAttributes() {
		if (attributes == null) {
			attributes = new int[]{this.color,this.shape,this.shading,this.number};
		}
		return attributes;
	}

}
