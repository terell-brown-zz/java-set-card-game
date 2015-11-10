
public class Card {
	
	private int color;
	private int shape;
	private int shading;
	private int number;
	private int[] attributes;
	
	public Card() {	
		this.attributes = new int[4];
	}
	
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
		this.attributes[0] = color;
	}

	public void setShape(int shape) {
		this.shape = shape;
		this.attributes[1] = shape;
	}

	public void setShading(int shading) {
		this.shading = shading;
		this.attributes[2] = shading;
	}

	public void setNumber(int number) {
		this.number = number;
		this.attributes[3] = number;
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
