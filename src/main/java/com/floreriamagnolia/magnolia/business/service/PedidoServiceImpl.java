package com.floreriamagnolia.magnolia.business.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreriamagnolia.magnolia.business.repository.IPedidoRepository;
import com.floreriamagnolia.magnolia.model.Cliente;
import com.floreriamagnolia.magnolia.model.Pedido;
import com.floreriamagnolia.magnolia.view.dto.PedidoDTO;

@Service
public class PedidoServiceImpl implements IPedidoService{
	
	@Autowired
	private IPedidoRepository repository;
	

	@Transactional
	@Override
	public Pedido createPedido(PedidoDTO pedidoDto) {
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		pedido.setDirecionPedido(pedidoDto.getDirecionPedido());
		pedido.setDescripcionPedido(pedidoDto.getDescripcionPedido());
		pedido.setHoraPedido(pedidoDto.getHoraPedido());
		pedido.setFechaEntraga(pedidoDto.getFechaEntraga());
		pedido.setCliente(cliente);
		return this.repository.save(pedido);
	}
	
	
	@Transactional
	@Override
	public Pedido updatePedido(Long idPedido,PedidoDTO pedidoDto) {
		
		Pedido pedido = this.repository.findByIdPedido(idPedido);

			pedido.setDirecionPedido(pedidoDto.getDirecionPedido());
			pedido.setDescripcionPedido(pedidoDto.getDescripcionPedido());
			pedido.setFechaEntraga(pedidoDto.getFechaEntraga());
			return this.repository.save(pedido);
	
	}
	
	@Transactional
	@Override
	public void deletePedido(Long idPedido) {
		Pedido pedido = this.repository.findByIdPedido(idPedido);
		if(pedido != null) {
			this.repository.delete(pedido);
		}
		
	}
	
	@Transactional(readOnly = true)
	@Override
	public Pedido findByIdPedido(Long idPedido) {
		return this.repository.findByIdPedido(idPedido);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Pedido findByFechaEntraga(Date fechaEntraga) {
		return this.repository.findByFechaEntraga(fechaEntraga);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Pedido> findAll() {
		return this.repository.findAll();
	}

	

}
