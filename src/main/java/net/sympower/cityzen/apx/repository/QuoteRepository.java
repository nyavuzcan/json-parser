package net.sympower.cityzen.apx.repository;

import net.sympower.cityzen.apx.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

}
