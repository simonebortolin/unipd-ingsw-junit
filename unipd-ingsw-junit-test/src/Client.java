public class Client
{
	public static void main(String[] argv)
	{
		Target<String> t = new ClassAdapter<String>();

		for(int i=0;i<argv.length;i++)
		{
			System.out.println(t + "; " + argv[i]);
			t.push(argv[i]);
			System.out.println(t);
		}

		while(!t.empty())
		{
			System.out.println(t + "; " + t.pop() + "; " + t);
		}

		t.pop();
	}
}
