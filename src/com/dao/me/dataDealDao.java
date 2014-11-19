package com.dao.me;

import java.util.List;

import com.entity.me.ParkData;

public interface dataDealDao {

	public void add(ParkData gh);

	public void update(ParkData gh);

	public boolean delete(String name);

	public boolean checkUserExistsWithName(String gwName);

	public List<ParkData> getParkList();
}
