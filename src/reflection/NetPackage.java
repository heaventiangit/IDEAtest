package reflection;

//网虫套餐类
public class NetPackage {
	private String name;
	private int talkTime;
	private int flow;
	private double price;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTalkTime() {
		return talkTime;
	}
	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}
	public int getFlow() {
		return flow;
	}
	public void setFlow(int flow) {
		this.flow = flow;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public NetPackage() {
		super();
		System.out.println("调用了 NetPackage 无参构造方法！");
	}
	public NetPackage(String name, int talkTime, int flow, double price) {
		super();
		this.name = name;
		this.talkTime = talkTime;
		this.flow = flow;
		this.price = price;
	}
	public NetPackage(String name) {
		super();
		this.name = name;
		System.out.println("调用了 NetPackage 的 String构造方法,name：" + name + "！");
	}
	public NetPackage(String name, int talkTime, int flow) {
		super();
		this.name = name;
		this.talkTime = talkTime;
		this.flow = flow;
	}
	
}