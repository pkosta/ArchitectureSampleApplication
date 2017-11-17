package architecture.sample.reusable.com.architecturesampleapplication.repo.mapper;

/*
 * Created by 849501 on 11/15/2017.
 */

public interface Mapper<Source, Destination> {
    Destination map(Source s);
}
