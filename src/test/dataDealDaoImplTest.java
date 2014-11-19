package test;

import org.junit.Test;

import com.dao.me.dataDealDao;
import com.daoimpl.me.dataDealDaoImpl;
import com.entity.me.ParkData;

public class dataDealDaoImplTest {

	// @Before
	// public void setUp() throws Exception {
	// }
	//
	// @After
	// public void tearDown() throws Exception {
	// }

	@Test
	public void testAdd() {
		ParkData data = new ParkData();
		data.setAddress("32s4");
		data.setStatus("0");
		dataDealDao dao = new dataDealDaoImpl();
		dao.add(data);
	}

	// @Test
	// public void testUpdate() {
	// ParkData data = new ParkData();
	// data.setAddress("32434");
	// data.setStatus("1");
	// dataDealDao dao = new dataDealDaoImpl();
	// dao.update(data);
	// }
	//
	// @Test
	// public void testDelete() {
	// dataDealDao dao = new dataDealDaoImpl();
	// dao.delete("32434");
	// }

	// @Test
	// public void testCheckUserExistsWithName() {
	// dataDealDao dao = new dataDealDaoImpl();
	// boolean exitsBoolean = dao.checkUserExistsWithName("32434");
	// if (exitsBoolean) {
	// System.out.println("exits");
	// }
	// }
	//
	// @Test
	// public void testGetParkList() {
	// dataDealDao dao = new dataDealDaoImpl();
	// List<ParkData> list = dao.getParkList();
	// System.out.println(list.get(1).getStatus());
	// }

}
