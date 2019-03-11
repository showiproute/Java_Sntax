package InterfaceReview;

public class ParentImpl implements ParentI1,ParentI2{
	//实现类实现接口，必须实现接口里面的所有方法，否则该实现类必须是抽象类
	
	@Override
	public void ff() {
		System.out.println("do ParentImpl.ff()");
	}

	@Override
	public void dd() {
		System.out.println("do ParentImpl1.dd()");
	}
	
	
	public static void main(String[] args) {

		//运用多态，创建子类对象给接口引用变量
		ParentI1 parentImpl = new ParentImpl();
		parentImpl.dd();
		
		ParentI2 parentImpl2 = new ParentImpl();
		parentImpl2.ff();
		
	}
	
}
