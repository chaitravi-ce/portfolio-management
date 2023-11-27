export interface StockDetails {
    meta: MetaData;
    values: StockValue[];
    status: string;
}

interface MetaData {
    symbol: string;
    interval: string;
    currency: string;
    exchange_timezone: string;
    exchange: string;
    mic_code: string;
    type: string;
}

interface StockValue {
    datetime: string;
    open: string;
    high: string;
    low: string;
    close: string;
    volume: string;
}
