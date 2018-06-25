package spittrz.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spittrz.Spittle;

@Component
public class SpittleTest implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return createSpittleList(20);
	}

	@Override
	public Spittle findOne(Long id) {
		return new Spittle("Hello",new java.sql.Date(id));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}
}
