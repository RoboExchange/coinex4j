package ir.moke.coinex.resource;

import ir.moke.coinex.model.Response;
import ir.moke.coinex.model.request.*;
import ir.moke.coinex.model.response.MarketResponse;
import ir.moke.coinex.model.response.OrderResponse;
import ir.moke.coinex.model.response.StopOrderResponse;
import ir.moke.coinex.model.response.TickerResponse;
import ir.moke.kafir.annotation.GET;
import ir.moke.kafir.annotation.POST;
import ir.moke.kafir.annotation.QueryParameter;

import java.util.List;

public interface Perpetual {

    @GET("/futures/market")
    Response<List<MarketResponse>> market(@QueryParameter("market") String market);

    @GET("/futures/ticker")
    Response<List<TickerResponse>> ticker(@QueryParameter("market") String market);

    @POST("/futures/order")
    Response<OrderResponse> order(Order order);

    @POST("/futures/stop-order")
    Response<StopOrderResponse> stopOrder(StopOrder stopOrder);

    @POST("/futures/batch-order")
    Response<List<Response<OrderResponse>>> batchOrder(BatchOrder batchOrder);

    @POST("/futures/batch-stop-order")
    Response<List<Response<StopOrderResponse>>> batchStopOrder(BatchStopOrder batchStopOrder);

    @GET("/futures/order-status")
    Response<OrderResponse> orderStatus(@QueryParameter("market") String market, @QueryParameter("order_ids") String orderIds);

    @GET("/futures/batch-order-status")
    Response<List<Response<OrderResponse>>> batchOrderStatus(@QueryParameter("market") String market, @QueryParameter("order_ids") String orderIds);

    @POST("/futures/modify-order")
    Response<OrderResponse> modifyOrder(ModifyOrder modifyOrder);

    @POST("/futures/modify-stop-order")
    Response<OrderResponse> modifyStopOrder(ModifyStopOrder modifyStopOrder);

    @POST("/futures/cancel-all-order")
    Response<Void> cancelAllOrder(CancelAllOrder cancelAllOrder);

    @POST("/futures/cancel-order")
    Response<OrderResponse> cancelOrder(CancelOrder cancelOrder);

    @POST("/futures/cancel-stop-order")
    Response<OrderResponse> cancelStopOrder(CancelStopOrder cancelStopOrder);

}
