export class Slot {
  slotId?: number;
  groundId?: number;
  slotDate?: string;
  slotStartTiming?: string;
  slotEndTiming?: string;
  status?: string; // This can be 'available' or 'booked'
  numberOfPlayers?: number;
}
