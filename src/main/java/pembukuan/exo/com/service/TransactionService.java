package pembukuan.exo.com.service;

import pembukuan.exo.com.dto.TransactionDTO;
import pembukuan.exo.com.entity.Customer;
import pembukuan.exo.com.entity.Transaction;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TransactionService {

    public List<Transaction> getAll() {
        return Transaction.listAll();
    }

    public Transaction create(TransactionDTO dto) {
        Customer customer = Customer.findById(dto.customerId);
        if (customer == null) return null;

        Transaction t = new Transaction();
        t.deskripsi = dto.deskripsi;
        t.jumlah = dto.jumlah;
        t.tipe = dto.tipe;
        t.tanggal = dto.tanggal;
        t.customer = customer;
        t.persist();
        return t;
    }

    public Transaction update(Long id, TransactionDTO dto) {
        Transaction t = Transaction.findById(id);
        if (t == null) return null;
        Customer customer = Customer.findById(dto.customerId);
        if (customer == null) return null;

        t.deskripsi = dto.deskripsi;
        t.jumlah = dto.jumlah;
        t.tipe = dto.tipe;
        t.tanggal = dto.tanggal;
        t.customer = customer;
        return t;
    }

    public boolean delete(Long id) {
        return Transaction.deleteById(id);
    }
}
