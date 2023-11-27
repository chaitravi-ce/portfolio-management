export interface Trade{
    id: number;
    stockTicker: string,
    stockPrice: number,
    volume: number,
    buyOrSell: string,
    statusCode: number
}