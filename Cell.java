public class Cell
{
	private boolean isMine, isFlagged, isObscured;
	private int number;

	public Cell()
	{
		isMine = false;
		isFlagged = false;
		isObscured = true;
		number = 0;
	}

	public void setMine()
	{
		isMine = true;
	}

	public void flag()
	{
		isFlagged = true;
	}

	public void unflag()
	{
		isFlagged = false;
	}

	public void reveal()
	{
		isObscured = false;
	}

	public void setNumber(int i)
	{
		number = i;
	}

	public boolean isMine()
	{
		return isMine;
	}

	public boolean isFlagged()
	{
		return isFlagged;
	}

	public boolean isObscured()
	{
		return isObscured;
	}

	public int getNumber()
	{
		return number;
	}
}