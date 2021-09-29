package example;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Urey
 * @Date: 2021/8/31
 */
// 所有的消息必须实现Delayed类，具体可以看DelayQueue的源码，泛型有限制
public class OrderMessage implements Delayed {

    private long id;
    private long createdAt;
    private long expiredAt;
    private int delayLevel;

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.toMillis(getExpiredAt() - System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(long expiredAt) {
        this.expiredAt = expiredAt;
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getExpiredAt(),((OrderMessage)o).getExpiredAt());
    }

    public OrderMessage(long id,long expiredAt,int delayLevel,long createdAt) {
        this.id = id;
        this.expiredAt = expiredAt;
        this.delayLevel = delayLevel;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OrderMessage{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", expiredAt=" + expiredAt +
                ", delayLevel=" + delayLevel +
                '}';
    }
}
