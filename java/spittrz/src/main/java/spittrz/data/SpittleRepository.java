package spittrz.data;

import java.util.List;

import spittrz.Spittle;

public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(Long id);
}
