import { selectAll } from "../repositories/singer.repository.js";


export async function getAllSingers() {
    let signers = await selectAll();
    return JSON.parse(signers);
}