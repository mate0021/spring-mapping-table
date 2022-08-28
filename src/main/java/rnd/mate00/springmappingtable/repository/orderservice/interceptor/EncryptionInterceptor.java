package rnd.mate00.springmappingtable.repository.orderservice.interceptor;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class EncryptionInterceptor extends EmptyInterceptor {

    private EncryptionService encryptionService;


    @Autowired
    public EncryptionInterceptor(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("... interceptor onSave()...");

        return super.onSave(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        System.out.println("... interceptor onFlushDirty()...");

        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }
}