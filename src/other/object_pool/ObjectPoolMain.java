package other.object_pool;

import java.util.LinkedList;
import java.util.List;

// bowling
public class ObjectPoolMain {

	public static void main(String[] args) {
		ObjectPool pool = new ObjectPool();
		
		PooledObject object = pool.getPooledObject();
		System.out.println("After getPooledObject: free.size=" + pool.free.size() + " used.size=" + pool.used.size());
		
		pool.releasePooledObject(object);
		System.out.println("After releasePooledObject: free.size=" + pool.free.size() + " used.size=" + pool.used.size());
	}
	
}

// shoe
class PooledObject {
	
}

// shelf
class ObjectPool {
	
	List<PooledObject> free = new LinkedList<>();
	List<PooledObject> used = new LinkedList<>(); 
	
	{
		free.add(new PooledObject());
		free.add(new PooledObject());
		free.add(new PooledObject());
	}
	
	PooledObject getPooledObject() {
		if (free.isEmpty()) {
			PooledObject pooledObject = new PooledObject();
			used.add(pooledObject);
			return pooledObject;
		} else {
			PooledObject pooledObject = free.get(0);
			used.add(pooledObject);
			free.remove(0);
			return pooledObject;
		}
	}
	
	void releasePooledObject(PooledObject pooledObject) {
		used.remove(pooledObject);
		free.add(pooledObject);
	}
	
}














