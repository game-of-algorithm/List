// 队列转栈
public class QueueToStack {

	Queue<String> q1;
	Queue<String> q2;

	public QueueToStack() {
		q1 = new Queue<String>();
		q2 = new Queue<String>();
	}

	public void push (String s) {
		Queue<String> in = q1.size() != 0 ? q1 : q2;
		in.enqueue(s);
	}

	public String pop () throws Exception {
		if (q1.isEmpty() && q2.isEmpty()) {
			throw new Exception("Stack is empty");
		}
		Queue<String> in = q1.size() == 0 ? q1 : q2;
		Queue<String> out = q1.size() == 0 ? q2 : q1;

		while (!out.isEmpty()) {
			String s = out.dequeue();
			if (out.size() == 0) {
				return s;
			}
			in.enqueue(s);
		}
		throw new Exception("Stack Error");
	}

	public static void main(String[] args) throws Exception {
		QueueToStack q2s = new QueueToStack();
		q2s.push("1");
		q2s.push("2");
		q2s.push("4");
		q2s.push("3");
		q2s.push("7");
		q2s.push("d");
		q2s.push("dsfb");
		q2s.push("he");
		System.out.println(q2s.pop());
		System.out.println(q2s.pop());
	}
}
