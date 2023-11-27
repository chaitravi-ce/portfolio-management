import { Trade } from "./Trade";
import { Stock } from "./Stock";

export interface User{
    id: number,
    username: string,
    name: string,
    trades: Trade[],
    stocks: Stock[]
}